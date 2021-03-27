package com.example.countdowntoTHPTQG;

public class QuestionLibrary {
    private String mQuestions[] = {
            "Trong các kim loại, kim loại có tính dẫn điện tốt nhất là?",
            "Kim loại nào sau đây không phản ứng với dung dịch CuSO4?",
            "Khí CO và H2 không thể dùng làm chất khử để điều chế kim loại nào sau đây:",
            "Tham dự Hội nghị Ianta (2-1945) có nguyên thủ của những quốc gia nào dưới đây?",
            "Có bao nhiêu nước là thành viên sáng lập tổ chức Liên hợp quốc?",
            "Theo quyết định của Hội nghị Ianta, nước nào sẽ chiếm đóng Nhật Bản sau Chiến tranh thế giới thứ hai?",
            "Bộ phận nào sau đây của vùng biển nước ta được xem như phần lãnh thổ trên đất liền?",
            "Vị trí địa lí đã quy định đặc điểm cơ bản của thiến nhiên nước ta mang tính chất",
            "Nước ta nằm hoàn toàn trong vùng nội chí tuyến bán cầu Bắc nên có",
    };

    private String mChoices[][] = {
            {"Vàng", "Bạc", "Đồng", "Nhôm"},
            {"Zn", "Al", "Fe", "Ag"},
            {"Fe", "Cu", "Al", "Sn"},
            {"Anh, Pháp, Mĩ", "Anh, Pháp, Đức", "Liên Xô, Mĩ, Anh", "Mĩ, Liên Xô, Trung Quốc"},
            {"30", "40", "45", "50"},
            {"Mĩ", "Anh", "Liên Xô", "Trung Quốc"},
            {"Nội thủy", "Vùng tiếp giáp lãnh hải", "Lãnh hải", "Thềm lục địa"},
            {"Nhiệt đới ẩm gió mùa", "Cận xích đạo gió mùa", "Cận nhiệt đới gió mùa", "Ôn đới gió mùa"},
            {"sông ngòi dày đặc", "địa hình đa dạng", "khoáng sản phong phú", "tổng bức xạ lớn"},
    };

    private String mCorrectAnswers[] = {"Bạc", "Ag", "Al", "Liên Xô, Mĩ, Anh", "50", "Mĩ", "Nội thủy", "Nhiệt đới ẩm gió mùa", "tổng bức xạ lớn"};

    public String getQuestion(int a){
        String question = mQuestions[a];
        return question;
    }

    public String getChoice1(int a){
        String choice0 = mChoices[a][0];
        return choice0;
    }

    public String getChoice2(int a){
        String choice1 = mChoices[a][1];
        return choice1;
    }

    public String getChoice3(int a){
        String choice2 = mChoices[a][2];
        return choice2;
    }

    public String getChoice4(int a){
        String choice3 = mChoices[a][3];
        return choice3;
    }

    public String getCorrectAnswer(int a){
        String answer = mCorrectAnswers[a];
        return answer;
    }
}
