import java.util.*;
public class CovidSpread {

    public static int findTime(int[][] hospital) {
        Queue<int[]> queue = new LinkedList<>();
        int unInfectedCount = 0;
        for(int i = 0; i < hospital.length; i++) {
            for(int j = 0; j < hospital[i].length; j++) {
                if(hospital[i][j] == 2) {
                    queue.add(new int[] {i, j});
                }
                if(hospital[i][j] == 1) {
                    unInfectedCount++;
                }
            }
        }
        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int time = 0;
        while(!queue.isEmpty() && unInfectedCount > 0) {
            time++;
            int size = queue.size();
            while(size-- > 0) {
                int[] temp = queue.poll();
				for (int[] direction : directions) {
					int currentI = temp[0] + direction[0];
					int currentJ = temp[1] + direction[1];

					if (currentI < 0 || currentJ < 0 || currentI >= hospital.length || currentJ >= hospital[0].length || hospital[currentI][currentJ] == 0 || hospital[currentI][currentJ] == 2) {
                        continue;
                    }
					queue.add(new int[]{currentI, currentJ}); 
					hospital[currentI][currentJ] = 2; 
					unInfectedCount--;
                }
            }
        }
        if(unInfectedCount == 0) {
            return time;
        }
        return -1;
    }
    public static void main(String[] args) { 
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();
        int cols = sc.nextInt();
        int[][] hospital = new int[rows][cols];
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                hospital[i][j] = sc.nextInt();
            }
        }
        System.out.println(findTime(hospital));
    }
}