package com.areteans.TicketBooking.service;
import com.areteans.TicketBooking.models.TrainJPA;
import com.areteans.TicketBooking.repository.TrainRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class TrainService {
    private final JdbcTemplate jdbcTemplate;
    private final TrainRepository trainRepository;
    public Map <String, Object> save(Map<String, Object> train ){
          jdbcTemplate.update("insert into train(trainID,trainName) values(?,?) ",
                Integer.parseInt((String) train.get("trainID")),
                 train.get("trainName"));
        return train;
    }
    public TrainJPA saveTrain(TrainJPA trainJPA) {
        return trainRepository.save(trainJPA);
    }
    public TrainJPA getTrainByID(Long ID) {
        Optional<TrainJPA> train = trainRepository.findById(ID);
        if (train.isPresent()) {
            return train.get();
        }
        return null;
    }
}
