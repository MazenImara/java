package simple.ex.dao;

import java.util.List;
import simple.ex.models.Item;

public interface ItemDAO {
    public List<Item> list();
    public void add(Item item);
    public void  update(Item item);
    public Item  getItem(Long id);
    public void  delete(Long id);
}
