import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {

    static List<Set<Integer>> components = new ArrayList<>();;
    static Set<Integer> edgesWithVertex = new HashSet<>();;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int eCount = sc.nextInt(); // 간선이 아예 없는 점도 고려해야함
        int vCount = sc.nextInt();

        for (int v = 0; v < vCount; v++) {
            int e1 = sc.nextInt();
            int e2 = sc.nextInt();
            updateComponents(e1, e2);
        }

        int componentCount = components.size();
        int edgesWithoutVertexCount = eCount - edgesWithVertex.size();

        System.out.println(componentCount + edgesWithoutVertexCount);
    }

    private static void updateComponents(int e1, int e2) {
        boolean containsE1 = false;
        int e1ComponentIndex = -1;
        boolean containsE2 = false;
        int e2ComponentIndex = -1;

        for (int index = 0; index < components.size(); index++) {
            Set<Integer> component = components.get(index);

            if (containsE1 && containsE2) {
                break;
            }
            if (component.contains(e1)) {
                containsE1 = true;
                e1ComponentIndex = index;
            }
            if (component.contains(e2)) {
                containsE2 = true;
                e2ComponentIndex = index;
            }
        }

        if (containsE1 && !containsE2) {
            components.get(e1ComponentIndex).add(e2);
        }
        if (!containsE1 && containsE2) {
            components.get(e2ComponentIndex).add(e1);
        }
        if (containsE1 && containsE2) {
            if (e1ComponentIndex != e2ComponentIndex) {
                components.get(e1ComponentIndex).addAll(components.get(e2ComponentIndex));
                components.remove(e2ComponentIndex);
            }
        }
        if (!containsE1 && !containsE2) {
            components.add(new HashSet<>(Arrays.asList(e1, e2)));
        }

        edgesWithVertex.add(e1);
        edgesWithVertex.add(e2);
    }
}
