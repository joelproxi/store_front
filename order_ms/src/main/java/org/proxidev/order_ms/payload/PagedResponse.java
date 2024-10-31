package org.proxidev.order_ms.payload;

import java.util.List;

public class PagedResponse<T> {
    private long totalElements;
    private int totalPages;
    private int number;
    private int size;
    private boolean first;
    private boolean last;
    private List<T> content;


    public PagedResponse(long totalElements, int totalPages, int number, int size, boolean first, boolean last, List<T> content) {
        this.totalElements = totalElements;
        this.totalPages = totalPages;
        this.number = number;
        this.size = size;
        this.first = first;
        this.last = last;
        this.content = content;
    }

    public PagedResponse() {
    }

    public static <T> PagedResponseBuilder<T> builder() {
        return new PagedResponseBuilder<T>();
    }

    public long getTotalElements() {
        return this.totalElements;
    }

    public int getTotalPages() {
        return this.totalPages;
    }

    public int getNumber() {
        return this.number;
    }

    public int getSize() {
        return this.size;
    }

    public boolean isFirst() {
        return this.first;
    }

    public boolean isLast() {
        return this.last;
    }

    public List<T> getContent() {
        return this.content;
    }

    public void setTotalElements(long totalElements) {
        this.totalElements = totalElements;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setFirst(boolean first) {
        this.first = first;
    }

    public void setLast(boolean last) {
        this.last = last;
    }

    public void setContent(List<T> content) {
        this.content = content;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof PagedResponse)) return false;
        final PagedResponse<?> other = (PagedResponse<?>) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.getTotalElements() != other.getTotalElements()) return false;
        if (this.getTotalPages() != other.getTotalPages()) return false;
        if (this.getNumber() != other.getNumber()) return false;
        if (this.getSize() != other.getSize()) return false;
        if (this.isFirst() != other.isFirst()) return false;
        if (this.isLast() != other.isLast()) return false;
        final Object this$content = this.getContent();
        final Object other$content = other.getContent();
        if (this$content == null ? other$content != null : !this$content.equals(other$content)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof PagedResponse;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final long $totalElements = this.getTotalElements();
        result = result * PRIME + (int) ($totalElements >>> 32 ^ $totalElements);
        result = result * PRIME + this.getTotalPages();
        result = result * PRIME + this.getNumber();
        result = result * PRIME + this.getSize();
        result = result * PRIME + (this.isFirst() ? 79 : 97);
        result = result * PRIME + (this.isLast() ? 79 : 97);
        final Object $content = this.getContent();
        result = result * PRIME + ($content == null ? 43 : $content.hashCode());
        return result;
    }

    public String toString() {
        return "PagedResponse(totalElements=" + this.getTotalElements() + ", totalPages=" + this.getTotalPages() + ", number=" + this.getNumber() + ", size=" + this.getSize() + ", first=" + this.isFirst() + ", last=" + this.isLast() + ", content=" + this.getContent() + ")";
    }

    public static class PagedResponseBuilder<T> {
        private long totalElements;
        private int totalPages;
        private int number;
        private int size;
        private boolean first;
        private boolean last;
        private List<T> content;

        PagedResponseBuilder() {
        }

        public PagedResponseBuilder<T> totalElements(long totalElements) {
            this.totalElements = totalElements;
            return this;
        }

        public PagedResponseBuilder<T> totalPages(int totalPages) {
            this.totalPages = totalPages;
            return this;
        }

        public PagedResponseBuilder<T> number(int number) {
            this.number = number;
            return this;
        }

        public PagedResponseBuilder<T> size(int size) {
            this.size = size;
            return this;
        }

        public PagedResponseBuilder<T> first(boolean first) {
            this.first = first;
            return this;
        }

        public PagedResponseBuilder<T> last(boolean last) {
            this.last = last;
            return this;
        }

        public PagedResponseBuilder<T> content(List<T> content) {
            this.content = content;
            return this;
        }

        public PagedResponse<T> build() {
            return new PagedResponse<T>(this.totalElements, this.totalPages, this.number, this.size, this.first, this.last, this.content);
        }

        public String toString() {
            return "PagedResponse.PagedResponseBuilder(totalElements=" + this.totalElements + ", totalPages=" + this.totalPages + ", number=" + this.number + ", size=" + this.size + ", first=" + this.first + ", last=" + this.last + ", content=" + this.content + ")";
        }
    }
}
