package com.example.demo.CourrierA;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CAService {

    private final CARepository caRepository;
    private static final Logger logger = LoggerFactory.getLogger(CAService.class);

    @Autowired
    public CAService(CARepository caRepository) {
        this.caRepository = caRepository;
    }

    public List<CAModel> getCA() {
        return caRepository.findAll();
    }

    public boolean addNewCA(CAModel ca) {
        boolean res = false;
        try {
            caRepository.save(ca);
            res = true;
        } catch (Exception e) {
            logger.error("Error adding new CA: ", e);
        }
        return res;
    }

    public void deleteCA(long caId) {
        boolean exists = caRepository.existsById(caId);
        if (!exists) {
            throw new IllegalStateException("Courrier with id " + caId + " does not exist");
        }
        caRepository.deleteById(caId);
    }

    @Transactional
    public void updateCA(long caId, String type, long num) {
        CAModel ca = caRepository.findById(caId)
                .orElseThrow(() -> new IllegalStateException(
                        "Courrier with id " + caId + " does not exist"));

        if (type != null && type.length() > 0 && !Objects.equals(ca.getType(), type)) {
            Optional<CAModel> caOptional = caRepository.findByType(type);
            if (caOptional.isPresent()) {
                throw new IllegalStateException("Type taken");
            }
            ca.setType(type);
        }

        if (num > 0 && !Objects.equals(ca.getNum(), num)) {
            Optional<CAModel> caOptional = caRepository.findeByNumber(num);
            if (caOptional.isPresent()) {
                throw new IllegalStateException("Number taken");
            }
            ca.setNum(num);
        }
    }

    public void updateCA(CAModel ca, long caId) {
        CAModel ca = caRepository.findById(caId)
                .orElseThrow(() -> new IllegalStateException(
                        "Courrier with id " + caId + " does not exist"));
    }
}
