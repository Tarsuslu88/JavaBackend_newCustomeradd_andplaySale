package com.dersler.new_play_sales.Controller;

import com.dersler.new_play_sales.Entities.Campaign;
import com.dersler.new_play_sales.Services.abstracts.ICampaignService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/campaign")
public class CampaignController {

    private final ICampaignService campaignService;

    public CampaignController(ICampaignService campaignService) {
        this.campaignService = campaignService;
    }

    @PostMapping("/add")
    public ResponseEntity<String> addCampaign(@RequestBody Campaign campaign) throws Exception {
        return campaignService.add(campaign);
    }

    @GetMapping("/all")
    public List<Campaign> getAllCampaign(){
        return campaignService.getAllCampaign();
    }

    @GetMapping("/{Id}")
    public Optional<Campaign> getCampaign(@PathVariable int Id){
        return campaignService.getCampaign(Id);
    }

    @PutMapping("/update/{Id}")
    public ResponseEntity<String> updateCampaign(@PathVariable int Id, @RequestBody Campaign campaign) throws Exception {
        return campaignService.updateCampaign(Id, campaign);
    }

    @DeleteMapping("/delete/{Id}")
    public void deleteCampaign(@PathVariable int Id){
        campaignService.deleteCampaign(Id);
    }

}
