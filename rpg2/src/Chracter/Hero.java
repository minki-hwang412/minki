package Chracter;

public class Hero extends Character {
	public int power, defense, experience;
	public int money = 0;
	public String name;

	public int attack() {
		int sum = level * 10 + power * 30;
		System.out.printf("%s의 공격!\n-> %d 데미지를 입힙니다.\n", name, sum);
		return sum;
	}

	public void attacked(int damage) {
		if (defense >= damage) {
			hp -= 0;
		} else {
			hp -= (damage - defense);
		}
		System.out.printf("%s가 공격받았습니다. 현재 HP: %d\n", name, hp);
	}
}
