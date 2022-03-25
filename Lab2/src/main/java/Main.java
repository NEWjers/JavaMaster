import dao.CarDAO;

public class Main {
    public static void main(String[] args) {
        CarDAO carDAO = new CarDAO();
        System.out.println(carDAO.getById(1));
    }
}
