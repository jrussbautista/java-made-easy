package com.example.jamesrussel.javamadeeasy;


public class QuestionQuiz {

    private String category;
    private String question;
    private String alternative1;
    private String alternative2;
    private String alternative3;
    private String alternative4;
    private String correctAnswer;


    /** a constructor for the instance of the QuestionQuiz
     * @param category category to the question
     * @param question question
     * @param alternative1 one of the alternative
     * @param alternative2 one of the alternative
     * @param alternative3 one of the alternative
     * @param alternative4 one of the alternative
     * @param correctAnswer correct answer to the question
     */
    public QuestionQuiz(String category, String question, String alternative1, String alternative2, String alternative3, String alternative4, String correctAnswer) {
        this.category = category;
        this.question = question;
        this.alternative1 = alternative1;
        this.alternative2 = alternative2;
        this.alternative3 = alternative3;
        this.alternative4 = alternative4;
        this.correctAnswer = correctAnswer;
    }

    /**
     * @return String category
     */
    public String getCategory() {
        return category;
    }

    /**
     * sets category to this instance
     * @param category category to set
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * @return String question
     */
    public String getQuestion() {
        return question;
    }

    /**
     * @return String alternative1
     */
    public String getAlternative1() {
        return alternative1;
    }

    /**
     * @return String alternative2
     */
    public String getAlternative2() {
        return alternative2;
    }

    /**
     * @return String alternative3
     */
    public String getAlternative3() {
        return alternative3;
    }

    /**
     * @return String alternative4
     */
    public String getAlternative4() {
        return alternative4;
    }

    /**
     * @return String correctAnswer
     */
    public String getCorrectAnswer() {
        return correctAnswer;
    }

}
