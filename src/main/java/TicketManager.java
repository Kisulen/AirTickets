import java.util.Arrays;
import java.util.Comparator;

public class TicketManager {

    private TicketRepository repo;
    Ticket ticket1 = new Ticket(1, 5357, "SVO", "CEK", 95);
    Ticket ticket2 = new Ticket(2, 5597, "SVO", "CEK", 87);
    Ticket ticket3 = new Ticket(3, 5260, "SVO", "CEK", 110);
    Ticket ticket4 = new Ticket(4, 5480, "SVO", "CEK", 98);
    Ticket ticket5 = new Ticket(5, 5386, "SVO", "CEK", 91);
    Ticket ticket6 = new Ticket(6, 4690, "VKO", "CEK", 80);
    Ticket ticket7 = new Ticket(7, 38500, "SVO", "JFK", 540);
    Ticket ticket8 = new Ticket(8, 1500, "DME", "LED", 63);

    public TicketManager(TicketRepository repo) {
        this.repo = repo;
    }

    public void add(Ticket ticket) {
        repo.save(ticket);
    }

    public boolean matches(Ticket ticket, String from, String to) {
        if (ticket.getFrom().contains(from) && ticket.getTo().contains(to)) {
            return true;
        } else {
            return false;
        }
    }

    public Ticket[] findAll(String from, String to, Comparator<Ticket> comparator) {
        Ticket[] result = new Ticket[0];
        for (Ticket ticket : repo.findTickets()) {
            if (matches(ticket, from, to)) {
                Ticket[] tmp = new Ticket[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = ticket;
                result = tmp;
            }
        }
        TicketTravelTimeComparator timeComparator = new TicketTravelTimeComparator();
        Arrays.sort(result, timeComparator);
        return result;
    }




}


