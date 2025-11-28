package br.com.fiap.controller;

import br.com.fiap.model.dto.AlunoDTO;
import br.com.fiap.model.entity.Aluno;
import br.com.fiap.model.repository.AlunoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

//Renato Luiz - RM556403

@RestController
@RequestMapping("/aluno")

public class AlunoController {

    @Autowired
    private AlunoRepository alunoRepository;

    @GetMapping("/novo")
    public ModelAndView novo(){
        ModelAndView mv = new ModelAndView("formulario");
        return mv;
    }

    @PostMapping
    public ModelAndView cadastrar(@Valid AlunoDTO alunoDTO, BindingResult result) {
        if (result.hasErrors()) {
            return new ModelAndView("redirect:/aluno");
        }
        Aluno aluno = new Aluno(alunoDTO);
        alunoRepository.save(aluno);
        ModelAndView mv = new ModelAndView("redirect:/aluno");
        return mv;
    }

    @GetMapping
    public ModelAndView consultar(){
        List<Aluno> alunos = alunoRepository.findAll();
        ModelAndView mv = new ModelAndView("alunos");
        mv.addObject("alunos", alunos);
        return mv;
    }

    @GetMapping("/editar/{codigo}")
    public ModelAndView consultarPorCodigo(@PathVariable Long codigo){
        Aluno aluno = alunoRepository.findByCodigo(codigo);
        ModelAndView mv = new ModelAndView("formulario");
        mv.addObject("aluno", aluno);
        mv.addObject("acao", "/aluno/atualizar/"+codigo);
        return mv;
    }

    @GetMapping("/excluir/{codigo}")
    public ModelAndView excluir(@PathVariable Long codigo){
        alunoRepository.deleteById(codigo);
        ModelAndView mv = new ModelAndView("redirect:/aluno");
        return mv;
    }

    @PostMapping("/atualizar/{codigo}")
    public ModelAndView atualizar(@PathVariable Long codigo, @Valid AlunoDTO alunoDTO, BindingResult result){
        if (result.hasErrors()) {
            return new ModelAndView("redirect:/aluno");
        }
        Aluno aluno = new Aluno(alunoDTO);
        aluno.setCodigo(codigo);
        alunoRepository.save(aluno);
        ModelAndView mv = new ModelAndView("redirect:/aluno");
        return mv;
    }
}