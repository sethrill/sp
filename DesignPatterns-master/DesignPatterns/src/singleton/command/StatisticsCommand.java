
package singleton.command;

import singleton.model.pattern.BookStatistics;
import singleton.singleton.DocumentManager;

public class StatisticsCommand implements Command {

  @Override
  public void execute() {
    singleton.model.pattern.BookStatistics stats = new BookStatistics();
    DocumentManager.getInstance().getBook().accept(stats);
    stats.printStatistics();

  }

}
