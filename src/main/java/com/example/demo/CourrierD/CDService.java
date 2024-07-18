package com.example.demo.CourrierD;

import com.example.demo.User.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CDService {

    private final CDRepository cdRepository;

    @Autowired
    public CDService(CDRepository cdRepository){
        this.cdRepository = cdRepository;
    }

    public List<CDModel> getCD(){
        return cdRepository.findAll();
    }

    public void addNewCD(CDModel cd){
        Optional<CDModel> cdOptional = cdRepository.findeByNumber(cd.getNum());
        if(cdOptional.isPresent()){
            throw new IllegalStateException("Courrier already exist");
        }
        cdRepository.save(cd);
    }

    public void deleteCD(Long cdId){
        boolean exist = cdRepository.existsById(cdId);
        if (!exist){
            throw new IllegalStateException("Courrier with id " + cdId + " does not exist");
        }
        cdRepository.deleteById(cdId);
    }

    @Transactional
    public void updateCD(Long cdId, String type, Long num) {
        CDModel cd = cdRepository.findById(cdId)
                .orElseThrow(() -> new IllegalStateException(
                        "Courrier with id " + cdId + " does not exist"));

        if (type != null && type.length() > 0 && !Objects.equals(cd.getType(), type)) {
            Optional<CDModel> cdOptional = cdRepository.findByType(type);
            if (cdOptional.isPresent()) {
                throw new IllegalStateException("name taken");
            }
            cd.setType(type);
        }
        if (num != null && num.longValue() > 0 && !Objects.equals(cd.getNum(), num)) {
            Optional<CDModel> cdOptional = cdRepository.findeByNumber(num);
            if (cdOptional.isPresent()) {
                throw new IllegalStateException("Email taken");
            }
            cd.setNum(num);
        }
    }
}
