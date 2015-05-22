@implementation IBActionTest

- (IBAction)telButtonTapped:(id)sender {
    [self.delegate telButtonTappedForCell:self];
}

- (IBAction)queryButtonTapped:(id)sender {
    if ([self.delegate respondsToSelector:@selector(queryTapped:forBookmarkCell:)]) {
        [self.delegate queryTapped:self.entity.query forBookmarkCell:self];
    }
}

@end
