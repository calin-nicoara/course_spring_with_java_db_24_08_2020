package ro.esolacad.springcourse;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GenericListModel<T> {

    private List<T> items;
    private long totalElements;
    private int totalPages;
}
