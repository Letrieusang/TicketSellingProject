package org.example.dto.ProductDto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.dto.BookDto.BookResDto;
import org.example.dto.CDDto.CDResDto;
import org.example.dto.DVDDto.DVDResDto;
import org.example.dto.LPDto.LPResDto;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDetailDto {
    private ProductResDto product;
    private BookResDto book;
    private DVDResDto dvd;
    private CDResDto cd;
    private LPResDto lp;


    public static ProductDetailDto createEntity(ProductResDto product, BookResDto book, DVDResDto dvd, CDResDto cd, LPResDto lp){
        return new ProductDetailDto(
                product,
                book,
                dvd,
                cd,
                lp
        );
    }
}
