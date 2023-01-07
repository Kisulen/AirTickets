import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RepositoryTest {

    Ticket ticket1 = new Ticket(1, 1357, "SVO", "CEK", 95);
    Ticket ticket2 = new Ticket(2, 1597, "SVO", "CEK", 87);
    Ticket ticket3 = new Ticket(3, 1260, "SVO", "CEK", 110);
    Ticket ticket4 = new Ticket(4, 1480, "SVO", "CEK", 98);
    Ticket ticket5 = new Ticket(5, 1386, "SVO", "CEK", 91);

    @Test
    public void shouldAddTickets() {
        TicketRepository repo = new TicketRepository();
        repo.save(ticket1);
        repo.save(ticket2);
        repo.save(ticket3);
        repo.save(ticket4);
        repo.save(ticket5);

        Ticket[] expected = {ticket1, ticket2, ticket3, ticket4, ticket5};
        Ticket[] actual = repo.findTickets();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindById() {
        TicketRepository repo = new TicketRepository();
        repo.save(ticket1);
        repo.save(ticket2);
        repo.save(ticket3);
        repo.save(ticket4);
        repo.save(ticket5);
        repo.findById(5);

        Ticket expected = ticket5;
        Ticket actual = repo.findById(5);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldRemoveById() {
        TicketRepository repo = new TicketRepository();
        repo.save(ticket1);
        repo.save(ticket2);
        repo.save(ticket3);
        repo.save(ticket4);
        repo.save(ticket5);
        repo.removeById(ticket1.getId());

        Ticket[] expected = {ticket2, ticket3, ticket4, ticket5};
        Ticket[] actual = repo.findTickets();

        Assertions.assertArrayEquals(expected, actual);

    }

}
