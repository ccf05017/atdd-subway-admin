package nextstep.subway.line.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SectionsTest {
    @DisplayName("중복 없이 역 ID 목록을 가져올 수 있다.")
    @Test
    void getStationsTest() {
        Long station1Id = 1L;
        Long station2Id = 2L;
        Long station3Id = 3L;
        int expectedSize = 3;

        Sections sections = new Sections();
        sections.add(new Section(1L, station1Id, station2Id, 3L));
        sections.add(new Section(2L, station2Id, station3Id, 5L));

        List<Long> stationIds = sections.getStationIds();

        assertThat(stationIds).hasSize(expectedSize);
    }

    @DisplayName("상행 종점역 구간을 찾아낼 수 있다.")
    @Test
    void findEndUpSectionTest() {
        Section endUpStation = new Section(1L, 2L, 10L);

        Sections sections = new Sections(new ArrayList<>(Arrays.asList(
                endUpStation,
                new Section(2L, 3L, 10L),
                new Section (3L, 4L, 10L)
        )));

        assertThat(sections.findEndUpSection()).isEqualTo(endUpStation);
    }

    @DisplayName("한 구간을 기준으로 다음 구간을 찾아낼 수 있다.")
    @Test
    void findNextSectionTest() {
        Section section1 = new Section(1L, 2L, 10L);
        Section section2 = new Section(2L, 3L, 10L);
        Section section3 = new Section (3L, 4L, 10L);

        Sections sections = new Sections(new ArrayList<>(Arrays.asList(section1, section2, section3)));
        Section endUpSection = sections.findEndUpSection();

        assertThat(sections.findNextSection(endUpSection)).isEqualTo(section2);
        assertThat(sections.findNextSection(section2)).isEqualTo(section3);
        assertThat(sections.findNextSection(section3)).isNull();
    }

    @DisplayName("구간 순서대로 정렬된 역 목록을 구할 수 있다.")
    @Test
    void getStationIdsOrderBySectionTest() {
        Section section1 = new Section(1L, 4L, 10L);
        Section section2 = new Section(4L, 3L, 10L);
        Section section3 = new Section (3L, 2L, 10L);
        Sections sections = new Sections(new ArrayList<>(Arrays.asList(section1, section2, section3)));

        List<Long> stationIds = sections.getStationIdsOrderBySection();

        assertThat(stationIds.get(0)).isEqualTo(1L);
        assertThat(stationIds.get(stationIds.size() - 1)).isEqualTo(2L);
    }
}
