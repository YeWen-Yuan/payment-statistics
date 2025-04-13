package show.ywy.reader;

import lombok.RequiredArgsConstructor;

import java.util.Collection;

/**
 * @author yzs
 */
@RequiredArgsConstructor
public abstract class ExcelAdapter{
    private final String path;

    public Collection<?> read() {
        return null;
    }
}
