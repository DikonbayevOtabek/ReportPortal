package com.epam.reportportal.product.http.model.request.user;

public class DeleteSpecifiedUserRequestBody {
    private static int ids;

    public  DeleteSpecifiedUserRequestBody(int ids) {
        DeleteSpecifiedUserRequestBody.ids = ids;
    }

    @Override
    public String toString() {
        return "{\n" +
                "  \"ids\": [\n" +
                "   " + ids +"\n" +
                "  ]\n" +
                "}";
    }
}
