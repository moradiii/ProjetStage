package com.example.demo.CourrierA;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CAService {

    private final CARepository caRepository;

    @Autowired
    public CAService(CARepository caRepository){
        this.caRepository = caRepository;
    }

    public List<CAModel> getCA(){
        return caRepository.findAll();
    }

    public void addNewCA(CAModel ca){
        Optional<CAModel> CAOptional = caRepository.findeByNumber(ca.getNum());
        if(CAOptional.isPresent()){
            throw new IllegalStateException("Courrier already exist");
        }
        caRepository.save(ca);
    }

    public void deleteCA(Long caId){
        boolean exist = caRepository.existsById(caId);
        if (!exist){
            throw new IllegalStateException("Courrier with id " + caId + " does not exist");
        }
        caRepository.deleteById(caId);
    }

    @Transactional
    public void updateCA(Long caId, String type, Long num) {
        CAModel ca = caRepository.findById(caId)
                .orElseThrow(() -> new IllegalStateException(
                        "Courrier with id " + caId + " does not exist"));

        if (type != null && type.length() > 0 && !Objects.equals(ca.getType(), type)) {
            Optional<CAModel> caOptional = caRepository.findByType(type);
            if (caOptional.isPresent()) {
                throw new IllegalStateException("name taken");
            }
            ca.setType(type);
        }
        if (num != null && num.longValue() > 0 && !Objects.equals(ca.getNum(), num)) {
            Optional<CAModel> caOptional = caRepository.findeByNumber(num);
            if (caOptional.isPresent()) {
                throw new IllegalStateException("Email taken");
            }
            ca.setNum(num);
        }
    }
}
