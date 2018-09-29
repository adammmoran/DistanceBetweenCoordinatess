package com.ua.controllers;

import com.ua.models.Point;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainRestController {
    @GetMapping("/api/latA={lat1}_lonA={lon1}_latB={lat2}_lonB={lon2}")
    public double main(@PathVariable double lat1, @PathVariable double lat2,
                       @PathVariable double lon1, @PathVariable double lon2){
        return distance(lat1,lat2,lon1,lon2);
    }

    @GetMapping("/load")
    public double load(@RequestBody Point point){
        return distance(point.lat1,point.lat2,point.lon1,point.lon2);
    }

    public double distance(double lat1, double lat2,
                           double lon1, double lon2){
        double phi1 = Math.toRadians(lat1);
        double phi2 = Math.toRadians(lat2);

        double deltaPhi = Math.toRadians(lat2-lat1);
        double deltaLambda = Math.toRadians(lon2-lon1);

        double a = Math.sin(deltaPhi/2) * Math.sin(deltaPhi/2) + Math.cos(phi1) * Math.cos(phi2) * Math.sin(deltaLambda/2) * Math.sin(deltaLambda/2);

        double c = 2 * Math.atan2(Math.sqrt(a),Math.sqrt(1-a));

        double R = 6000;

        return R *c;
    }
}
