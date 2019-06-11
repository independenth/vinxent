package web;
import java.util.*;
import org.springframework.ui.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;


@Controller
class Web {
    
    @RequestMapping("/")
    String showIndex() {
        return "index";
    }
    
    @RequestMapping("/all")
    String showAll(Model m) {
        m.addAttribute("code", list);
        return "all";
    }        
    
    int [] list = {10700, 11000, 11100, 10450, 10500};
    @RequestMapping("/available/{code}") @ResponseBody
    String showAvailable(@PathVariable int code) {
        String result = "No";
        for (int x : list) {
            if (code == x) result = "Yes";
        }
        return result;
    }
    
    @RequestMapping("/rectangle/{width}/{height}") @ResponseBody //web service
    double showARea(@PathVariable("width") double w, @PathVariable("height") double h) {
        return w * h;
    }
    /*
    double showArea(@PathVariable double width, @PathVariable double height) {
        return width * height;
    }
    */
    @RequestMapping("/car")
    String showCar(String engine, Double cc, Model m) {
        if (engine != null && cc != null) {
            if (engine.equals("Diesel")) m.addAttribute("total", cc * 0.85);
            if (engine.equals("Gasoline")) m.addAttribute("total", cc * 1.05);
        }
        return "car";
    }
    
    @RequestMapping("/product")
    String showProduct(Model model) {
        model.addAttribute("shop", "iCoffee");
        String[] data = {"Mocha", "Latte"};
        model.addAttribute("data", data);
        return "product";
    }
    
    @RequestMapping("/branch")
    String showBranch() {
        return "branch";
        
    }
}

@RestController
class Service {
    
    @RequestMapping("/test2")
    ArrayList<Staff> showAllStaff() {
        ArrayList list = new ArrayList<Staff>();
        Staff s1 = new Staff();
        s1.name = "Tony"; s1.salary = 50000; s1.gender = 'M';
        Staff s2 = new Staff();
        s2.name = "Pepper"; s2.salary = 40000; s2.gender = 'F';
        list.add(s1);
        list.add(s2);
        return list;
    }
    
    @RequestMapping("/test1")
    Staff showStaff() {
        Staff s = new Staff();
        s.name = "Tony Stark";
        s.salary = 70000;
        s.gender = 'M';
        return s;
    }
    
    @RequestMapping("/area")
    double showArea(double width, double height) {
        return width*height;
    }
    
    @RequestMapping("/coffee")
    String[] showCoffee() {
        String[] data = {"Latte", "Mocha" };
        return data;
    }
    
    @RequestMapping("/test")
    int showTest() {
        return 555;
    }
   
}

class Staff {
    public String name;
    double salary;
    public char gender;
}