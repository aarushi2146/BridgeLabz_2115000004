
public class CircularTour {
    static class PetrolPump {
        int petrol;
        int distance;
        PetrolPump(int petrol, int distance) {
            this.petrol = petrol;
            this.distance = distance;
        }
    }
    public static int tour(PetrolPump[] pumps) {
        int totalPetrol = 0, totalDistance = 0, start = 0, surplus = 0;
        for (int i = 0; i < pumps.length; i++) {
            totalPetrol += pumps[i].petrol;
            totalDistance += pumps[i].distance;
            surplus += pumps[i].petrol - pumps[i].distance;
            if (surplus < 0) {
                start = i + 1;
                surplus = 0;
            }
        }
        return (totalPetrol < totalDistance) ? -1 : start;
    }
    public static void main(String[] args) {
        PetrolPump[] pumps = {
            new PetrolPump(4, 6),
            new PetrolPump(6, 5),
            new PetrolPump(7, 3),
            new PetrolPump(4, 5)
        };
        int start = tour(pumps);
        System.out.println(start);
    }
}

