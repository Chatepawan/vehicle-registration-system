    package com.pavan.vehicle.controller;

    import com.pavan.vehicle.model.Vehicle;
    import com.pavan.vehicle.model.VehicleSearchCriteria;
    import com.pavan.vehicle.service.SearchService;
    import org.springframework.stereotype.Controller;
    import org.springframework.ui.Model;
    import org.springframework.web.bind.annotation.GetMapping;
    import org.springframework.web.bind.annotation.ModelAttribute;
    import org.springframework.web.bind.annotation.PostMapping;
    import org.springframework.web.bind.annotation.RequestMapping;

    import java.util.List;

    @Controller
    @RequestMapping("/search")
    public class SearchController {
        private final SearchService searchService;

        public SearchController(SearchService searchService) {
            this.searchService = searchService;
        }

        @GetMapping
        public String showSearchForm(Model model) {
            model.addAttribute("searchCriteria", new VehicleSearchCriteria());
            return "search/form";
        }

        @PostMapping
        public String performSearch(@ModelAttribute VehicleSearchCriteria criteria, Model model) {
            List<Vehicle> results = searchService.advancedSearch(criteria);
            model.addAttribute("results", results);
            return "search/results";
        }
    }
