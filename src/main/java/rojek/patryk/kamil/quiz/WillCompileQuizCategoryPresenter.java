package rojek.patryk.kamil.quiz;

import static rojek.patryk.kamil.communication.MessageHandler.logMessageFromBundle;

import rojek.patryk.kamil.communication.UserInput;

class WillCompileQuizCategoryPresenter extends TrueFalseQuizPresenter {
  WillCompileQuizCategoryPresenter(UserInput userInput) {
    super(userInput, QuestionCategory.WILL_COMPILE);
  }

  WillCompileQuizCategoryPresenter(UserInput userInput, int questionLimit) {
    super(userInput, QuestionCategory.WILL_COMPILE, questionLimit);
  }

  @Override
  protected void displayCategoryDescription() {
    logMessageFromBundle("WILL_COMPILE_CATEGORY_DESCRIPTION");
  }
}
