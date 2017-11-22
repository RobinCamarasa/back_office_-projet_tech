package com.robin.camarasa.nutritvecoach.web.Controller;

import com.robin.camarasa.nutritvecoach.dao.PhysicalDataDao;
import com.robin.camarasa.nutritvecoach.model.PhysicalData;
import com.robin.camarasa.nutritvecoach.web.dto.PhysicalDataDto;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@RestController
@RequestMapping(value = "/api/physicaldatas")
@Transactional
public class PhysicalDataController {

    private final PhysicalDataDao physicalDataDao;
    private PhysicalData physicalData;

    public PhysicalDataController(PhysicalDataDao physicalDataDao) {
        this.physicalDataDao = physicalDataDao;
    }

    @GetMapping(value = "/{physicalDataId}")
    public PhysicalDataDto get(@PathVariable Long physicalDataId) {
        return (new PhysicalDataDto(physicalDataDao.getOne(physicalDataId)));
    }

    @PostMapping(value = "/add/{age}/{size}/{weight}")
    public PhysicalDataDto add(@PathVariable Integer age, @PathVariable Float size, @PathVariable Float weight) {
        physicalData = new PhysicalData(age,weight,size);
        physicalDataDao.save(physicalData);
        return (new PhysicalDataDto(physicalData));
    }
}