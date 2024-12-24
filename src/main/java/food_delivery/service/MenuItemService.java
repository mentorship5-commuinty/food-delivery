package food_delivery.service;

import food_delivery.model.CartItem;
import food_delivery.model.MenuItem;
import food_delivery.repository.MenuItemRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MenuItemService {

    private final MenuItemRepository menuItemRepository;

    @Transactional
    public void reduceInventory(List<CartItem> itemList)
    {
        for (CartItem item:itemList)
        {
            reduceInventory(item);
        }
    }

    private void reduceInventory(CartItem cartItem) {
        Long id = cartItem.getMenuItem().getMenuItemId();
        MenuItem menuItem = menuItemRepository.findById(id).orElseThrow(()->new RuntimeException("cart has undefined menu item"));

        if(menuItem.getQuantity() < cartItem.getQuantity())
        {
            throw new RuntimeException("not enough inventory for item with id: "+menuItem.getMenuItemId());
        }
        menuItem.setQuantity(menuItem.getQuantity() - cartItem.getQuantity());
        menuItemRepository.save(menuItem);
    }
}
