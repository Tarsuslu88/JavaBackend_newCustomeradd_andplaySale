package com.dersler.new_play_sales.Services.concrete;

import com.dersler.new_play_sales.Entities.Campaign;
import com.dersler.new_play_sales.Entities.Customer;
import com.dersler.new_play_sales.Entities.Games;
import com.dersler.new_play_sales.Repository.CampaignRepository;
import com.dersler.new_play_sales.Services.abstracts.ICampaignService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CampaignManager implements ICampaignService {

    private final CampaignRepository campaignRepository;


    public CampaignManager(CampaignRepository campaignRepository) {
        this.campaignRepository = campaignRepository;
    }

    @Override
    public ResponseEntity<String> add(Campaign campaign) throws Exception {
        Optional<Campaign> kampanya = campaignRepository.findByCampaignName(campaign.getCampaignName());

        try {
            if(kampanya.isEmpty()){
                campaignRepository.save(campaign);
                return ResponseEntity.ok("Kampanya başarılı bir şekilde kaydedildi.");
            }else{
                return ResponseEntity.badRequest().body("Bu kampanya daha önceden kayıt edilmiştir!");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<Campaign> getAllCampaign() {
        return campaignRepository.findAll();
    }

    @Override
    public Optional<Campaign> getCampaign(int Id) {
        return campaignRepository.findById(Id);
    }

    @Override
    public ResponseEntity<String> updateCampaign(int Id, Campaign campaign) throws Exception {
        Optional<Campaign> CampaignDbs = campaignRepository.findById(Id);
        if(CampaignDbs.isPresent()){
            Campaign toUpdateCampaignDb = CampaignDbs.get();
            if(campaign.getCampaignName() != toUpdateCampaignDb.getCampaignName() && campaign.getCampaignName().length()>0)
                toUpdateCampaignDb.setCampaignName(campaign.getCampaignName());
            if(campaign.getDescription() != toUpdateCampaignDb.getDescription() && campaign.getDescription().length()>0)
                toUpdateCampaignDb.setDescription(campaign.getDescription());
            if(campaign.getSales() != toUpdateCampaignDb.getSales())
                toUpdateCampaignDb.setSales(campaign.getSales());
            campaignRepository.save(toUpdateCampaignDb);

            return ResponseEntity.ok("Kampanya bilgileri başarılı bir şekilde güncellenmiştir.");
        }else {
            return ResponseEntity.badRequest().body("güncellemek istediğiniz kampanya veritabanında bulunamadı");
        }
    }


    @Override
    public void deleteCampaign(int Id) {
        campaignRepository.deleteById(Id);
    }


}
