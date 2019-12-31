import UIKit
import app

class ViewController: UIViewController, QuoteView {
    
    private let quotePresenter = QuotePresenter()
    
    override func viewDidLoad() {
        super.viewDidLoad()
        label.text = "Loading..."
        quotePresenter.quoteView = self
        quotePresenter.requestQuote()
    }
    
    override func viewWillDisappear(_ animated: Bool) {
        super.viewWillDisappear(animated)
        quotePresenter.quoteView = nil
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
    }
    
    func showQuote(quote: String) {
        label.text = quote
    }
    
    @IBOutlet weak var label: UILabel!
}
