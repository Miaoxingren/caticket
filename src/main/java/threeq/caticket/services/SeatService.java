package threeq.caticket.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import threeq.caticket.entities.Chair;
import threeq.caticket.entities.Line;

@Service
public class SeatService {
	
	private List<Line> lines;
	
	public SeatService() {
        super();
    }
	
	public Line createLine(int number) {
		Line line = new Line();
		line.setNumber(number);
		line.setChairs(createChairs(9));
		return line;
	}
	public List<Chair> createChairs(int cnt) {
		List<Chair> chairs = new  ArrayList<Chair>();
		for (int i = 0; i < cnt; i++) {
			Chair chair = new Chair();
			chair.setNumber(i);
			chairs.add(chair);
		}
		return chairs;
	}
	
	public List<Line> findAll() {
		if (this.lines == null) {
			this.lines = new ArrayList<Line>();
			for (int i = 1; i <= 7; i++) {
				this.lines.add(createLine(i));
			}
		}
        return this.lines;
    }

    public Line findByLine(final int line) {
        return this.lines.get(line);
    }
    
}
