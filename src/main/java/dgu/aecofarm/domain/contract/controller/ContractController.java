package dgu.aecofarm.domain.contract.controller;

import dgu.aecofarm.domain.contract.service.ContractService;
import dgu.aecofarm.dto.contract.ContractDetailResponseDTO;
import dgu.aecofarm.dto.contract.CreateContractRequestDTO;
import dgu.aecofarm.entity.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/contract")
public class ContractController {

    private final ContractService contractService;

    @PostMapping("/post")
    public Response<?> createContract(@RequestBody CreateContractRequestDTO postRequestDTO, Authentication auth) {
        try {
            return Response.success(contractService.createContract(postRequestDTO, auth.getName()));
        } catch (Exception e) {
            return Response.failure(e);
        }
    }

    @PutMapping("/update/{contractId}")
    public Response<?> updateContract(@PathVariable("contractId") Long contractId, @RequestBody CreateContractRequestDTO postRequestDTO, Authentication auth) {
        try {
            return Response.success(contractService.updateContract(contractId, postRequestDTO, auth.getName()));
        } catch (Exception e) {
            return Response.failure(e);
        }
    }

    @DeleteMapping("/delete/{contractId}")
    public Response<?> deleteContract(@PathVariable("contractId") Long contractId, Authentication auth) {
        try {
            return Response.success(contractService.deleteContract(contractId, auth.getName()));
        } catch (Exception e) {
            return Response.failure(e);
        }
    }

    @GetMapping("/detail/{contractId}")
    public Response<?> getContractDetail(@PathVariable("contractId") Long contractId) {
        try {
            ContractDetailResponseDTO contractDetail = contractService.getContractDetail(contractId);
            return Response.success(contractDetail);
        } catch (Exception e) {
            return Response.failure(e.getMessage());
        }
    }
}
