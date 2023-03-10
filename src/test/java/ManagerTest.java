import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ManagerTest {

    Ticket ticket1 = new Ticket(1, 5357, "SVO", "CEK", 95);
    Ticket ticket2 = new Ticket(2, 5597, "SVO", "CEK", 87);
    Ticket ticket3 = new Ticket(3, 5260, "SVO", "CEK", 110);
    Ticket ticket4 = new Ticket(4, 5480, "SVO", "CEK", 98);
    Ticket ticket5 = new Ticket(5, 5386, "SVO", "CEK", 91);
    Ticket ticket6 = new Ticket(6, 4690, "VKO", "CEK", 80);
    Ticket ticket7 = new Ticket(7, 38500, "SVO", "JFK", 540);
    Ticket ticket8 = new Ticket(8, 1500, "DME", "LED", 63);


    TicketRepository repo = new TicketRepository();

    @Test
    public void shouldFindTickets() {
        TicketManager manager = new TicketManager(repo);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.findAll("SVO", "CEK");

        Ticket[] expected = {ticket3, ticket1, ticket5, ticket4, ticket2};
        Ticket[] actual = manager.findAll("SVO", "CEK");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotFindIfNone() {
        TicketManager manager = new TicketManager(repo);

        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.findAll("SVO", "CEK");

        Ticket[] expected = {};
        Ticket[] actual = manager.findAll("SVO", "CEK");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldFindSingleMatch() {
        TicketManager manager = new TicketManager(repo);

        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.findAll("SVO", "CEK");

        Ticket[] expected = {ticket5};
        Ticket[] actual = manager.findAll("SVO", "CEK");

        Assertions.assertArrayEquals(expected, actual);

    }

}

