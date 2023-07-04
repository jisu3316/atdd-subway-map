package subway.subwayline;

import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.springframework.http.MediaType;
import subway.subwayline.dto.CreateSubwayLineRequest;
import subway.subwayline.dto.ModifySubwayLineRequest;

public class SubwayLineSteps {

    public static CreateSubwayLineRequest 지하철노선등록요청_생성(String name, String color, Long upStationId, Long downStationId, int distance) {
        return CreateSubwayLineRequest.builder()
                .name(name)
                .color(color)
                .upStationId(upStationId)
                .downStationId(downStationId)
                .distance(distance)
                .build();
    }

    public static ExtractableResponse<Response> 지하철노선등록요청(CreateSubwayLineRequest request) {
        return RestAssured.given().log().all()
                .body(request)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .when().post("/lines")
                .then().log().all()
                .extract();
    }

    public static ExtractableResponse<Response> 지하철노선목록조회요청() {
        return RestAssured.given().log().all()
                .when().get("/lines")
                .then().log().all()
                .extract();
    }

    public static ExtractableResponse<Response> 지하철노선조회요청(Long id) {
        return RestAssured.given().log().all()
                .when().get("/lines/{id}", id)
                .then().log().all()
                .extract();
    }

    public static ModifySubwayLineRequest 지하철노선수정요청_생성(String name, String color) {
        return ModifySubwayLineRequest.builder()
                .name(name)
                .color(color)
                .build();
    }

    public static ExtractableResponse<Response> 지하철노선수정요청(Long id, ModifySubwayLineRequest request) {
        return RestAssured.given().log().all()
                .body(request)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .when().put("/lines/{id}", id)
                .then().log().all()
                .extract();
    }

    public static ExtractableResponse<Response> 지하철노선삭제요청(Long id) {
        return RestAssured.given().log().all()
                .when().delete("/lines/{id}", id)
                .then().log().all()
                .extract();
    }
}
