package com.krunch.topicsearch.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.krunch.topicsearch.entity.SearchKeyWordData;
import com.krunch.topicsearch.service.KrunchAnalyticsService;
import com.krunch.topicsearch.vo.SeaarchKeyword;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/analytics")
public class KrunchCollaborationController {

	}
