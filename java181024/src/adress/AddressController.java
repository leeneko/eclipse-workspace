package adress;

import java.util.ArrayList;

public class AddressController {

	private ArrayList<AddressBookVO> list = new ArrayList<AddressBookVO>();
	
	public AddressBookVO getList(int i) {
		return list.get(i);
	}
	
	public int length() {
		return list.size();
	}
	
	public void addList(String name, int age, String tel, String address) {
		AddressBookVO arg0 = new AddressBookVO(name, age, tel, address);
		list.add(arg0);
	}
	
	public void addList(AddressBookVO s) {
		list.add(s);
	}

	public AddressBookVO select(String search_name) {
		// TODO Auto-generated method stub
		AddressBookVO vo = null;
		
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getName().equals(search_name)) {
				vo = list.get(i);
				break;
			}
		}
		return vo;
	}

	public void delete(String next) {
		// TODO Auto-generated method stub
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getName().equals(next)) {
				list.remove(i);
				break;
			}
		}
	}
}
