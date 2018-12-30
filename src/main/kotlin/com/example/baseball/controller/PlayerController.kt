package com.example.baseball.controller

import com.example.baseball.domain.Player
import com.example.baseball.service.PlayerService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@Controller
@RequestMapping("/players")
class PlayerController(private val playerService: PlayerService) {
    @GetMapping
    fun index(model: Model): String {
        model.addAttribute("players", playerService.findAll())
        return "players/index"
    }

    @GetMapping("new")
    fun newPlayer(model: Model): String {
        model.addAttribute("player", Player())
        return "players/new"
    }

    @GetMapping("{id}/edit")
    fun edit(@PathVariable id: Long, model: Model): String {
        model.addAttribute("player", playerService.findOne(id));
        return "players/edit"
    }

    @GetMapping("{id}")
    fun show(@PathVariable id: Long, model: Model): String {
        model.addAttribute("player", playerService.findOne(id));
        return "players/show"
    }

    @PostMapping
    fun create(@Valid @ModelAttribute player: Player, bindingResult: BindingResult): String {
        if (bindingResult.hasErrors()) return "players/new";
        playerService.save(player)
        return "redirect:/players"
    }

    @PutMapping("{id}")
    fun update(@PathVariable id: Long, @Valid @ModelAttribute player: Player, bindingResult: BindingResult): String {
        if (bindingResult.hasErrors()) return "players/edit";
        playerService.save(player.copy(id = id))
        return "redirect:/players"
    }

    @DeleteMapping("{id}")
    fun destroy(@PathVariable id: Long): String {
        playerService.delete(id)
        return "redirect:/players"
    }

}