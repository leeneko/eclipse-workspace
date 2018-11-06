package photoShop;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		// 메뉴 출력
		// (1) Circle (2) Rect (3) Tri (4) draw(전체 그리기)
		// >> 1
		// (1) Circle (2) Rect (3) Tri (4) draw(전체 그리기)
		// >> 2
		// (1) Circle (2) Rect (3) Tri (4) draw(전체 그리기)
		// >> 4
		// 원 그리기
		// 사각형 그리기
		Scanner sc = new Scanner(System.in);
		ArrayList<Shape> list = new ArrayList<Shape>();
		int select = 0;
		while (select != 4) {
			System.out.println("(1) Circle (2) Rect (3) Tri (4) draw(전체 그리기)");
			System.out.print(">> ");
			select = sc.nextInt();
			if (select == 1) {
				list.add(new Circle());
			} else if (select == 2) {
				list.add(new Rect());
			} else if (select == 3) {
				list.add(new Tri());
			} else if (select == 4) {
				for (Shape s : list) {
					s.draw();
				}
			}
		}
		sc.close();
		
	}
	
}
