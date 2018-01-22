package com.sofusit.poalimbootstrap.service;

import com.sofusit.poalimbootstrap.data.entity.Sign;
import com.sofusit.poalimbootstrap.data.repository.SignRepo;
import com.sofusit.poalimbootstrap.excpetion.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SignService {

    @Autowired
    private SignRepo signRepo;

    public Sign findById(String signId) throws ResourceNotFoundException {
        return signRepo.findById(signId).orElseThrow(() -> new ResourceNotFoundException("sign id:" + signId));
    }

    @Transactional
    public Sign updateSign(Sign sign) throws ResourceNotFoundException, IllegalArgumentException {
        Sign existingSign = this.findById(sign.getId());

        // Some validation ...

        // Update only permitted fields
        existingSign.setName(sign.getName());
        existingSign.setIsSigned(sign.getIsSigned());

        return signRepo.save(existingSign);
    }
}
