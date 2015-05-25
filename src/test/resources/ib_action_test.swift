class IBActionTest {

    @IBAction func telButtonTapped(sender: AnyObject) {
        self.delegate.telButtonTappedForCell(self)

    }

    @IBAction func queryButtonTapped(sender: AnyObject) {
        if self.delegate.respondsToSelector("queryTapped:forBookmarkCell:") {
            self.delegate.queryTapped(self.entity.query, forBookmarkCell: self)
        }

    }

}
