package org.vader.saber.controller;

import java.util.List;
import java.util.ArrayList;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.vader.saber.dto.GuestbookDTO;
import org.vader.saber.dto.PageRequestDTO;
import org.vader.saber.dto.PageResultDTO;
import org.vader.saber.service.GuestbookService;
import org.vader.saber.entity.Guestbook;

@RestController
@RequestMapping("/api")
@Log4j2
@RequiredArgsConstructor
public class GuestbookRestController {

    private final GuestbookService service;

    @GetMapping("/list")
    public PageResultDTO<GuestbookDTO, Guestbook> list(PageRequestDTO pageRequestDTO, Model model) {

        log.info("api list >>>> " + pageRequestDTO);

        return service.getList(pageRequestDTO);

    }
}