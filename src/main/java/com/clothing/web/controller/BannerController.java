package com.clothing.web.controller;

import com.clothing.web.model.Banner;
import com.clothing.web.service.BannerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 描述:
 *
 * @author partner
 * @create 2018-10-01 1:00
 */
@RestController
@Slf4j
@RequestMapping("/banner")
public class BannerController {

    @Autowired
    private BannerService bannerService;

    @PostMapping("/getBanners")
    public ResponseEntity getBanners(String groupKey) {
        try {
            log.info("【标题】 参数groupKey={}", groupKey);
            List<Banner> banners = bannerService.selectBannerByGroupKey(groupKey);
            return ResponseEntity.ok(banners);
        } catch (Exception e) {
            e.printStackTrace();
            log.info("【标题】 获取标题数据，异常信息={}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
