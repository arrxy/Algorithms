package Generics;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Pair<TYPE1, TYPE2> {
    private TYPE1 left;
    private TYPE2 right;
}
