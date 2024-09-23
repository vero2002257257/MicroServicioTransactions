package com.example.E_mazon.application.dto.request;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StockUpdateRequest {
    @NonNull
    private Long productId;
    @NonNull
    private int quantity;
}
