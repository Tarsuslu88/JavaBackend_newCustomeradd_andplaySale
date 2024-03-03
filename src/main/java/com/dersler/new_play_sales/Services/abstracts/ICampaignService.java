package com.dersler.new_play_sales.Services.abstracts;

import com.dersler.new_play_sales.Entities.Campaign;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface ICampaignService {

    ResponseEntity<String> add(Campaign campaign) throws Exception;

    List<Campaign> getAllCampaign();

    Optional<Campaign> getCampaign(int Id);

    ResponseEntity<String> updateCampaign(int Id, Campaign campaign) throws Exception;

    void deleteCampaign(int Id);

}
