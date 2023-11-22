package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.dao.CarsDao;

import java.util.PrimitiveIterator;

@Controller
@RequestMapping (value = "/cars")
public class CarsController {

    private CarsDao carsDao;
    @Autowired
    public CarsController(CarsDao carsDao) {
        this.carsDao = carsDao;
    }

    @GetMapping
    public String printSomeCars(@RequestParam(required = false, name = "count") Integer count, ModelMap model) {
        carsDao.putCars();
        if (count != null) {
        model.addAttribute( "someCars", carsDao.getSomeCars(count));
        } else {
            model.addAttribute("someCars",carsDao.getAllCars());
        }
        return "/cars";
    }
}
