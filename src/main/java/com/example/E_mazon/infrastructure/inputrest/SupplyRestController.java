package com.example.E_mazon.infrastructure.inputrest;
import com.example.E_mazon.application.dto.request.SupplyRequest;
import com.example.E_mazon.application.dto.response.SupplyResponse;
import com.example.E_mazon.application.handler.ISupplyHandler;
import com.example.E_mazon.infrastructure.security.SecurityUser;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import static com.example.E_mazon.utils.Constants.AUTH_TOKEN;


@RestController
@RequestMapping("/supply")
@RequiredArgsConstructor
public class SupplyRestController {

    private final ISupplyHandler supplyHandler;


    @Operation(summary = "Crear una nueva transacción de suministro",
            description = "Crea una nueva transacción de suministro")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Transacción de suministro creada", content = @Content(schema = @Schema(implementation = SupplyResponse.class))),
            @ApiResponse(responseCode = "400", description = "Petición inválida"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @PostMapping
    public ResponseEntity<Void> createSupply(@RequestBody SupplyRequest supplyRequest,
                                             @RequestHeader(AUTH_TOKEN) String token) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        SecurityUser userDetails = (SecurityUser) authentication.getPrincipal();
        Long userId = userDetails.getId();
        supplyHandler.saveSupply(supplyRequest, userId, token);
        return ResponseEntity.status(HttpStatus.CREATED).build();

    }
}
