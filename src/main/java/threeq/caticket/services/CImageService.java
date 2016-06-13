package threeq.caticket.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import threeq.caticket.entities.CImage;
import threeq.caticket.entities.repositories.CImageRepository;

@Service
public class CImageService {
	@Autowired
	private CImageRepository cimageRepository;
	
	public CImageService() {
        super();
    }
	
    public CImage findByName(final String name) {
        return this.cimageRepository.findByName(name);
    }
    
    public CImage findById(final int id) {
        return this.cimageRepository.findById(id);
    }
}
