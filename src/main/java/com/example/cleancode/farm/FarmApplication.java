package com.example.cleancode.farm;

import com.example.cleancode.farm.animal.Chick;
import com.example.cleancode.farm.animal.Cow;
import com.example.cleancode.farm.animal.Pig;
import com.example.cleancode.farm.feeding.BirdFeedingStation;
import com.example.cleancode.farm.feeding.CattleFeedingStation;
import com.example.cleancode.farm.paddock.MaterialDeliveryCompany;
import com.example.cleancode.farm.paddock.MaterialType;
import com.example.cleancode.farm.paddock.Paddock;
import com.example.cleancode.farm.walking.FenceController;
import com.example.cleancode.farm.walking.WalkingScheduler;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FarmApplication {

    public static void main(String[] args) {
        MaterialDeliveryCompany materialDeliveryCompany = new MaterialDeliveryCompany();
        OldMacdonaldJob oldMacdonaldJob = new OldMacdonaldJob(new MaterialDeliveryCompany(),
                new WalkingScheduler(new FenceController(MaterialType.Wood, materialDeliveryCompany)),
                new BirdFeedingStation(new GrainProvider("")),
                new CattleFeedingStation(new GrassProvider("x600 - grass authority")),
                new Paddock(1, 2, MaterialType.Wood, materialDeliveryCompany)
        );
        oldMacdonaldJob.liveNormalDayAtFarm(generateCows(), generatePigs(), generateChicks());
    }

    private static List<Cow> generateCows() {
        return IntStream.range(0, 5)
                .mapToObj(i -> new Cow(""+i))
                .collect(Collectors.toList());
    }

    private static List<Pig> generatePigs() {
        return IntStream.range(0, 3)
                .mapToObj(i -> new Pig(""+i))
                .collect(Collectors.toList());
    }

    private static List<Chick> generateChicks() {
        return IntStream.range(0, 7)
                .mapToObj(i -> new Chick(""+i))
                .collect(Collectors.toList());
    }

}
