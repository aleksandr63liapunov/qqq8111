package conf.cont;

import model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import service.Service;
import service.Serviceint;

import java.util.List;

@Controller
public class UserController {
    private Serviceint serviceint = new Service();

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String getUserTab(Model model) {
        List<User> users = serviceint.getAll();
        model.addAttribute("userlist", users);
        return "people";
    }

    @RequestMapping(value = "/addnew", method = RequestMethod.GET)
    public String addNewUserPage() {
        return "newpeople";
    }

    @RequestMapping(value = "/addnew", method = RequestMethod.POST)
    public String addNewUser(@RequestParam(value = "id") int id, @RequestParam(value = "name") String name, @RequestParam(value = "age") int age) {
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setAge(age);
        serviceint.save(user);
        return "redirect:/user";

    }

    @DeleteMapping("/delete/{id}")
    public String deleteItem(@PathVariable("id") int id) {
        User user = serviceint.getById(id);
        serviceint.delete(user);
        return "redirect:/user";
        //    return "people";
    }
    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", serviceint.getById(id));
        return "user/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") User user, @PathVariable("id") int id) {
        serviceint.update(id, user);
        return "redirect:/user";
    }

}
