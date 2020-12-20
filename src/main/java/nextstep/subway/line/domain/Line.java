package nextstep.subway.line.domain;

import nextstep.subway.common.BaseEntity;

import javax.persistence.*;

@Entity
public class Line extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String name;
    private String color;
    private Sections sections = new Sections();

    public Line() {
    }

    public Line(String name, String color) {
        this(null, name, color);
    }

    Line(Long id, String name, String color) {
        this.id = id;
        this.name = name;
        this.color = color;
    }

    public void update(Line line) {
        this.name = line.getName();
        this.color = line.getColor();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public int getSectionsSize() {
        return sections.size();
    }

    public void addNewSection(final Long upStationId, final Long downStationId, final Long distance) {
        this.sections.add(new Section(upStationId, downStationId, distance));
    }
}
