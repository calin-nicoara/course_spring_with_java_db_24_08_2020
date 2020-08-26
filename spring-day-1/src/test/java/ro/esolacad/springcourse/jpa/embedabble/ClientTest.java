package ro.esolacad.springcourse.jpa.embedabble;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ClientTest {

    @Autowired
    private ClientRepository clientRepository;

    @Test
    public void testModifyingDates() {
        Client client = Client
                .builder()
                .id(null)
                .name("Ionut Popescu")
                .credit(BigDecimal.valueOf(20))
                .numberOfOrders(10)
                .clientAddress(
                        new ClientAddress("Iuliu Maniu", "244")
                )
                .build();

        Client save = clientRepository.save(client);

        clientRepository.findById(save.getId())
                .ifPresent(clientFromRepo -> {
                    System.out.println(clientFromRepo);
                    System.out.println(clientFromRepo.getCreatedAt());
                    System.out.println(clientFromRepo.getUpdatedAt());
                });
    }

}
